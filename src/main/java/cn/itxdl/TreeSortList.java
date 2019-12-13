package cn.itxdl;

public class TreeSortList {
    private Node root;

    public void add(int data){
        if(root == null){
            root = new Node(data);
        }else{
            root.add(data);
        }
    }

    public Node get(int data){
        if(root == null){
            return null;
        }else if(root.data == data){
            return root;
        }
        return root.get(data);
    }

    public boolean remove(int data){
        if(root == null){
            return false;
        }else{
            Node node = null;
            root.remove(root,data);
            return true;
        }
    }

    public boolean set(int oldData,int newData){
         remove(oldData);
         add(newData);
         return true;
    }

    public void print(){
        root.middlePrint();
    }

    class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data) {
            this.data = data;
        }

        public void add(int data){
            if(data < this.data){
               if(this.left == null){
                  this.left = new Node(data);
               }else{
                   this.left.add(data);
               }
            }else if(data > this.data){
               if (this.right == null){
                  this.right = new Node(data);
               }else{
                   this.right.add(data);
               }
            }
        }

        public Node get(int data){
            Node node = null;
            if(data < this.data){
                if(data == this.left.data){
                    node = this.left;
                    return node;
                }else{
                    return this.left.get(data);
                }
            }else if(data > this.data){
                if(data == this.right.data){
                   node = this.right;
                   return node;
                }else {
                    return this.right.get(data);
                }
            }
            return node;
        }

        /**
         * 中序遍历
         */
        public void middlePrint(){
            if(this.left != null){
                this.left.middlePrint();
            }
            System.out.print(">>"+this.data);
            if(this.right != null){
                this.right.middlePrint();
            }
        }

        /**
         * 先序遍历
         */
        public void frontPrint(){
            System.out.print(">>"+this.data);
            if(this.left != null){
                this.left.middlePrint();
            }
            if(this.right != null){
                this.right.middlePrint();
            }
        }



        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        /**
         * 删除节点
         * @param node
         * @param data
         * @return
         */
        public Node remove(Node node,int data) {
            if(data == node.data){
                 if(node.left == null && node.right == null){
                     return null;
                 }
                 if(node.left == null){
                     return node.right;
                 }
                 if(node.right == null){
                     return node.left;
                 }
                 if(node.left != null && node.right != null){
                     Node temp = getSmallest(node.right);
                     node.data = temp.data;
                     node.right = remove(node.right,temp.data);
                     return temp;
                 }
            }else {
                if(data < node.data){
                   node.left =  remove(node.left,data);
                }else{
                   node.right =  remove(node.right,data);
                }
                return node;
            }
            return node;
        }

        public Node getSmallest(Node node){
            while(node.left != null){
                node = node.left;
            }
            return node;
        }
    }
}
