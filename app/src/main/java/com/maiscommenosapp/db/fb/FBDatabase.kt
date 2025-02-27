package com.maiscommenosapp.db.fb

import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.firestore
import com.maiscommenosapp.model.Mercadinho
import com.maiscommenosapp.model.Ong
import com.maiscommenosapp.model.Pedido
import com.maiscommenosapp.model.Produto
import com.maiscommenosapp.model.User

class FBDatabase {
    interface Listener {
        fun onMercadinhoLoaded(mercadinho: Mercadinho)
        fun onOngLoaded(ong: Ong)
        fun onProdutoAdded(produto: Produto)
        fun onProdutoUpdated(produto: Produto)
        fun onProdutoRemoved(produto: Produto)
        fun onPedidoAdded(pedido: Pedido)
        fun onPedidoUpdated(pedido: Pedido)
        fun onPedidoRemoved(pedido: Pedido)
    }
    private val auth = Firebase.auth
    private val db = Firebase.firestore
    private var produtosListReg: ListenerRegistration? = null
    private var pedidosListReg: ListenerRegistration? = null
    private var listener : Listener? = null
    init {
        auth.addAuthStateListener { auth ->
            if (auth.currentUser == null) {
                produtosListReg?.remove()
                return@addAuthStateListener
            }
            /*val refCurrUser = db.collection("users")
                .document(auth.currentUser!!.uid)
            refCurrUser.get().addOnSuccessListener {
                it.toObject(FBUser::class.java)?.let { user ->
                    listener?.onUserLoaded(user.toUser())
                }
            }*/

            val refCurrMercadinho = db.collection("mercadinhos")
                .document(auth.currentUser!!.uid)
            refCurrMercadinho.get().addOnSuccessListener {
                it.toObject(FBMercadinho::class.java)?.let { mercadinho ->
                    listener?.onMercadinhoLoaded(mercadinho.toMercadinho())
                }
            }

            val refCurrOng = db.collection("ongs")
                .document(auth.currentUser!!.uid)
            refCurrOng.get().addOnSuccessListener {
                it.toObject(FBOng::class.java)?.let { ong ->
                    listener?.onOngLoaded(ong.toOng())
                }
            }
            produtosListReg = refCurrMercadinho.collection("produtos")
                .addSnapshotListener { snapshots, ex ->
                    if (ex != null) return@addSnapshotListener
                    snapshots?.documentChanges?.forEach { change ->
                        val fbProduto = change.document.toObject(FBProduto::class.java)
                        if (change.type == DocumentChange.Type.ADDED) {
                            listener?.onProdutoAdded(fbProduto.toProduto())
                        } else if (change.type == DocumentChange.Type.REMOVED) {
                            listener?.onProdutoRemoved(fbProduto.toProduto())
                        }
                    }
                }
            produtosListReg = refCurrMercadinho.collection("produtos")
                .addSnapshotListener { snapshots, ex ->
                    if (ex != null) return@addSnapshotListener
                    snapshots?.documentChanges?.forEach { change ->
                        val fbProduto = change.document.toObject(FBProduto::class.java)
                        if (change.type == DocumentChange.Type.ADDED) {
                            listener?.onProdutoAdded(fbProduto.toProduto())
                        } else if (change.type == DocumentChange.Type.REMOVED) {
                            listener?.onProdutoRemoved(fbProduto.toProduto())
                        }
                    }
                }
            pedidosListReg = refCurrOng.collection("pedidos")
                .addSnapshotListener { snapshots, ex ->
                    if (ex != null) return@addSnapshotListener
                    snapshots?.documentChanges?.forEach { change ->
                        val fbPedido = change.document.toObject(FBPedido::class.java)
                        if (change.type == DocumentChange.Type.ADDED) {
                            listener?.onPedidoAdded(fbPedido.toPedido())
                        } else if (change.type == DocumentChange.Type.REMOVED) {
                            listener?.onPedidoRemoved(fbPedido.toPedido())
                        }
                    }
                }

            pedidosListReg = refCurrMercadinho.collection("pedidos")
                .addSnapshotListener { snapshots, ex ->
                    if (ex != null) return@addSnapshotListener
                    snapshots?.documentChanges?.forEach { change ->
                        val fbPedido = change.document.toObject(FBPedido::class.java)
                        if (change.type == DocumentChange.Type.ADDED) {
                            listener?.onPedidoAdded(fbPedido.toPedido())
                        } else if (change.type == DocumentChange.Type.REMOVED) {
                            listener?.onPedidoRemoved(fbPedido.toPedido())
                        }
                    }
                }
        }
    }
    fun setListener(listener: Listener? = null) {
        this.listener = listener
    }
    fun register(ong: Ong) {
        if (auth.currentUser == null)
            throw RuntimeException("User not logged in!")
        val uid = auth.currentUser!!.uid
        db.collection("ongs").document(uid + "").set(ong.toFBOng());
    }
    fun register(mercadinho: Mercadinho) {
        if (auth.currentUser == null)
            throw RuntimeException("User not logged in!")
        val uid = auth.currentUser!!.uid
        db.collection("mercadinhos").document(uid + "").set(mercadinho.toFBMercadinho());
    }
    fun addProduto(produto: Produto) {
        if (auth.currentUser == null)
            throw RuntimeException("User not logged in!")
        val uid = auth.currentUser!!.uid
        db.collection("mercadinhos").document(uid).collection("produtos")
            .document(produto.name).set(produto.toFBProduto())
    }

    fun removeProduto(produto: Produto) {if (auth.currentUser == null)
        throw RuntimeException("User not logged in!")
        val uid = auth.currentUser!!.uid
        db.collection("mercadinhos").document(uid).collection("produtos")
            .document(produto.name).delete()
    }
    fun addPedido(pedido: Pedido) {
        if (auth.currentUser == null)
            throw RuntimeException("User not logged in!")
        val uid = auth.currentUser!!.uid
        db.collection("users").document(uid).collection("pedidos")
            .document(pedido.name).set(pedido.toFBPedido())
    }
    fun removePedido(pedido: Pedido) {if (auth.currentUser == null)
        throw RuntimeException("User not logged in!")
        val uid = auth.currentUser!!.uid
        db.collection("users").document(uid).collection("pedidos")
            .document(pedido.name).delete()
    }
}
