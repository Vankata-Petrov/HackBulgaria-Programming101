
public class BST {
	private class Node {
		private int value;
		private Node right;
		private Node left;
		private int depth;
		private int height;
		private Node parrent=null;

		public Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public int getDepth() {
			return depth;
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Node getParrent() {
			return parrent;
		}

		public void setParrent(Node parrent) {
			this.parrent = parrent;
		}
	}

	public Node root;

	public void add(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			newNode.setDepth(0);
			newNode.setHeight(0);
			root = newNode;
			return;
		}
		Node current = root;
		Node parrent = null;
		
		while (true) {
			if (current.getValue() > value) {
				parrent = current;
				current = current.getLeft();
				if (current == null) {
					parrent.setLeft(newNode);
					newNode.setParrent(parrent);
					break;
				}
			} else if (current.getValue() < value) {
				parrent = current;
				current = current.getRight();
				if (current == null) {
					newNode.setParrent(parrent);
					
					parrent.setRight(newNode);
					break;
				}
			}
		}
	}

	public boolean find(int value) {
		if (root == null) {
			return false;
		}
		Node current = root;
		while (true) {
			if (current == null) {
				return false;
			}
			if (current.getValue() == value) {System.out.println(current.getParrent().getValue());
				return true;
			} else if (current.getValue() > value) {
				current = current.getLeft();
			} else if (current.getValue() < value) {
				current = current.getRight();
			}
		}
	}

	public boolean delete(int value) {
		Node current = root;
		Node parrent = null;
		boolean isLeftChild = true;

		while (current.getValue() != value) {
			parrent = current;
			if (current.getValue() > value) {
				isLeftChild = true;
				current = current.getLeft();
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
			if (current == null) {
				return false;
			}
		}

		if (current.getLeft() == null && current.getRight() == null) {
			if (isLeftChild) {
				parrent.setLeft(null);
			} else {
				parrent.setRight(null);
			}
		} else if (current.getLeft() == null && current.getRight() != null) {
			if (!isLeftChild) {
				parrent.setRight(current.getRight());
			} else {
				parrent.setLeft(current.getRight());
			}
			current = current.getRight();
		} else if (current.getLeft() != null && current.getRight() == null) {
			if (!isLeftChild) {
				parrent.setRight(current.getLeft());
			} else {
				parrent.setLeft(current.getLeft());
			}
			current = current.getLeft();
		} else {
			parrent = current;
			Node newCurrent = current.getRight();
			if (newCurrent.getLeft() != null) {
				while (true) {
					if (newCurrent.getLeft() != null) {
						parrent = newCurrent;
						newCurrent = newCurrent.getLeft();
					} else {
						current.setValue(newCurrent.getValue());
						parrent.setLeft(null);
						break;
					}
				}
			}
			else{
				parrent.setValue(newCurrent.getValue());
				parrent.setRight(null);
			}
		}
		return true;
	}

	public void display(Node root) {
		if (root != null) {
			display(root.getLeft());
			System.out.print(" " + root.getValue());
			display(root.getRight());
		}
	}
}
