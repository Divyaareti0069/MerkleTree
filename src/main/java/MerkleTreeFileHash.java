import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MerkleTreeFileHash {
	public static ArrayList<Node> childNodes;
	 public static Node generateTree(ArrayList<String> dataBlocks) {
	        childNodes = new ArrayList<>();
	        for (String name : dataBlocks) {
	        	String hash = MD5FileHash.generateHashFile(name);
	            childNodes.add(new Node(null, null,hash));
	            System.out.println(name+" : "+hash);
	        }
	        return buildTree(childNodes);
	  }


	 private static Node buildTree(ArrayList<Node> children) {
		 	LinkedHashMap<Node,String>  nodesMap = new LinkedHashMap<>();
		 	
	        ArrayList<Node> parents = new ArrayList<>();
	        
	        while (children.size() != 1) {
	            int index = 0, length = children.size();
	            while (index < length) {
	                Node leftChild = children.get(index);
	                Node rightChild = null;

	                if ((index + 1) < length) {
	                    rightChild = children.get(index + 1);
	                } else {
	                    rightChild = new Node(null, null, leftChild.getHash());
	                    
	                }

	                String parentHash = MD5FileHash.generateHashText(leftChild.getHash() + rightChild.getHash());
	                parents.add(new Node(leftChild, rightChild, parentHash));
	                index += 2;
	            }
	            children = parents;
	            parents = new ArrayList<>();
	        }
	        return children.get(0);
	   }



	    private static void printLevelOrderTraversal(Node root) {
	        if (root == null) {
	            return;
	        }

	        if ((root.getLeft() == null && root.getRight() == null)) {
	            System.out.println(root.getHash());
	        }
	        Queue<String> nodeNames = new LinkedList<>();
	        nodeNames.add("root : ");
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(root);
	        queue.add(null);

	        while (!queue.isEmpty()) {
	            Node node = queue.poll();
	            if (node != null) {
	            	//root
	                System.out.print(nodeNames.poll());

	                System.out.println(node.getHash());
	            } else {
	                System.out.println();
	                if (!queue.isEmpty()) {
	                    queue.add(null);
	                   // nodeNames.add("null");
	                }
	            }

	            if (node != null && node.getLeft() != null) {
	            	nodeNames.add("left : ");
	                queue.add(node.getLeft());
	            }

	            if (node != null && node.getRight() != null) {
	            	nodeNames.add("right : ");
	                queue.add(node.getRight());
	            }
	        }
	    }


	public static void main(String[] args) {

		 	ArrayList<String> list = new ArrayList<>();
		 	list.add("test1.txt");
		 	list.add("test2.txt");
		 	list.add("test3.txt");
		 	list.add("test4.txt");
		 	
	        Node root = generateTree(list);
	        System.out.println();
	        printLevelOrderTraversal(root);
	        
	        

	}

}
