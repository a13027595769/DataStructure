package com.supremind.map.RBTree.binaryTree;//package src.com.supremind.RBTreeTrueBak.binaryTree;
//
//
//import java.util.Comparator;
//
//public class RBTreeBakTwo<E> extends BBST<E> {
//    private static final boolean RED = false;
//    private static final boolean BLACK = true;
//
//    public RBTreeBakTwo(){
//        this(null);
//    }
//    public RBTreeBakTwo(Comparator<E> comparator){
//        super(comparator);
//    }
//    private Node<E> color(Node<E> node,boolean color){
////        if(node == null) return node;
////        ((RBNode<E>)node).color = color;
////        return node;
////        TODO
//          if(node != null){
//              ((RBNode<E>)node).color = color;
//          }
//          return node;
//    }
//
//    @Override
//    protected void afterAdd(Node<E> node) {
//        //传过来的node节点就是新添加的节点，因为你要根据判断当前节点的叔父节点是不是红色啊之类的
//        //也要判断父节点
//        Node<E> parent = node.parent;
//        //如果添加的是根节点，直接染成黑色,如果上溢到了根节点，也是把它当做新添加的节点，新添加的节点也是染成黑色的
//
//        if(parent == null){
//            black(node);
//            return;
//        }
//        //如果父节点是黑的，那你直接return就行了，这四种情况不用考虑
//        if(isBlack(parent))return;
//        //uncle节点
//        Node<E> uncle = parent.sibling();
//        //祖父节点
//       // Node<E> grand = parent.parent;
//        //这里直接把一个染成红色的节点给你接收了。
//        Node<E> grand = red(parent.parent);
//        if(isRed(uncle)){
//            black(parent);
//            black(uncle);
//            //把祖父节点当做是新添加的节点
////            red(grand);
//////            afterAdd(grand);
////            afterAdd(red(grand));
//            //发现后面的都要染成红色，那还是能够抽取的。
//            return;
//        }
////        //叔父节点不是红色
////        if(parent.isLeftChild()){//L
////            if(node.isLeftChild()){//LL
////                black(parent);
////                red(grand);
////                rotateRight(grand);
////            }else{//LR
////                black(node);
////                red(grand);
////                rotateLeft(parent);
////                rotateRight(grand);
////            }
////        }else{//R
////            if(node.isLeftChild()){//RL
////                black(node);
////                red(grand);
////                rotateRight(parent);
////                rotateLeft(grand);
////            }else {//RR
////                black(parent);
////                red(grand);
////                rotateLeft(grand);
////            }
////        }
//                //叔父节点不是红色
//        if(parent.isLeftChild()){//L
//            red(grand);
//
//            if(node.isLeftChild()){//LL
//                black(parent);
//            }else{//LR
//                black(node);
//                rotateLeft(parent);
//            }
//            rotateRight(grand);
//
//        }else{//R
//            red(grand);
//            if(node.isLeftChild()){//RL
//                black(node);
//                rotateRight(parent);
//            }else {//RR
//                black(parent);
//            }
//            rotateLeft(grand);
//
//        }
//    }
//
//    @Override
//	protected void afterRemove(Node<E> node) {
//	// 如果删除的节点是红色
//	if (isRed(node)) return;
//
//	// 用以取代node的子节点是红色
//	if (isRed(node)) {
//		black(node);
//		return;
//	}
//
//	Node<E> parent = node.parent;
//	// 删除的是根节点
//	if (parent == null) return;
//
//	// 删除的是黑色叶子节点【下溢】
//	// 判断被删除的node是左还是右
//	boolean left = parent.left == null || node.isLeftChild();
//	Node<E> sibling = left ? parent.right : parent.left;
//	if (left) { // 被删除的节点在左边，兄弟节点在右边
//		if (isRed(sibling)) { // 兄弟节点是红色
//			black(sibling);
//			red(parent);
//			rotateLeft(parent);
//			// 更换兄弟
//			sibling = parent.right;
//		}
//
//		// 兄弟节点必然是黑色
//		if (isBlack(sibling.left) && isBlack(sibling.right)) {
//			// 兄弟节点没有1个红色子节点，父节点要向下跟兄弟节点合并
//			boolean parentBlack = isBlack(parent);
//			black(parent);
//			red(sibling);
//			if (parentBlack) {
//				afterRemove(parent);
//			}
//		} else { // 兄弟节点至少有1个红色子节点，向兄弟节点借元素
//			// 兄弟节点的左边是黑色，兄弟要先旋转
//			if (isBlack(sibling.right)) {
//				rotateRight(sibling);
//				sibling = parent.right;
//			}
//
//			color(sibling, colorOf(parent));
//			black(sibling.right);
//			black(parent);
//			rotateLeft(parent);
//		}
//	} else { // 被删除的节点在右边，兄弟节点在左边
//		if (isRed(sibling)) { // 兄弟节点是红色
//			black(sibling);
//			red(parent);
//			rotateRight(parent);
//			// 更换兄弟
//			sibling = parent.left;
//		}
//
//		// 兄弟节点必然是黑色
//		if (isBlack(sibling.left) && isBlack(sibling.right)) {
//			// 兄弟节点没有1个红色子节点，父节点要向下跟兄弟节点合并
//			boolean parentBlack = isBlack(parent);
//			black(parent);
//			red(sibling);
//			if (parentBlack) {
//				afterRemove(parent);
//			}
//		} else { // 兄弟节点至少有1个红色子节点，向兄弟节点借元素
//			// 兄弟节点的左边是黑色，兄弟要先旋转
//			if (isBlack(sibling.left)) {
//				rotateLeft(sibling);
//				sibling = parent.left;
//			}
//
//			color(sibling, colorOf(parent));
//			black(sibling.left);
//			black(parent);
//			rotateRight(parent);
//		}
//	}
//	}
//
//    @Override
//    protected Node<E> createNode(E element, Node<E> parent) {
//        return new RBNode<>(element, parent);
//    }
//
//    private Node<E> red(Node<E> node){
//        return color(node,RED);
//    }
//
//    private Node<E> black(Node<E> node){
//        return color(node,BLACK);
//    }
//
//    private boolean colorOf(Node<E> node){
//        return node == null ? BLACK : ((RBNode<E>)node).color;
//    }
//
//    private boolean isBlack(Node<E> node){
//        return colorOf(node) == BLACK;
//    }
//    private boolean isRed(Node<E> node){
//        return colorOf(node) == RED;
//    }
//    private static class RBNode<E> extends Node<E>{
//        boolean color = RED;
//        public RBNode(E element, Node<E> parent) {
//            super(element, parent);
//        }
//
//        @Override
//        public String toString() {
//            String str = "";
//            if(color == RED){
//                str = "R_";
//            }
//            return str + element.toString();
//        }
//    }
//
//}
