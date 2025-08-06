package _01_data_structure._02_non_linear._03_avl_tree;


public class AVLTree<T extends Comparable<T>>{

    BinaryTree<T> root;

    public AVLTree() {
        this.root = null;
    }

    public AVLTree(BinaryTree<T> rootNode) {
        this.root = rootNode;
    }

    public BinaryTree<T> search(T targetData) {
        return searchNode(this.root, targetData);
    }

    private BinaryTree<T> searchNode(BinaryTree<T> currentNode, T targetData) {
        //현재 노드가 null (트리가 비어있거나, 찾는 값 없음) null 반환
        if (currentNode == null) {
            return null;
        }

        int comparison = targetData.compareTo(currentNode.getData());

        if (comparison == 0) {
            //찾는 값 찾았음
            return currentNode;
        } else if (comparison < 0) {
            //targetData 가 작으면 왼쪽 서브트리로
            return searchNode(currentNode.getLeftSubTree(), targetData);
        } else {
            // comarison > 0, 즉 targetData가 더 크면 오른쪽 서브트리로

            return searchNode(currentNode.getRightSubTree(), targetData);
        }
    }


    public void insert(T data) {
        this.root = insert(this.root, data);
    }

    public void remove(T data) {
        this.root = remove(this.root, data, null);
    }

    private BinaryTree<T> remove(BinaryTree<T> targetRootNode, T data, BinaryTree<T> parentNode) {
        if (targetRootNode.getData().compareTo(data) < 0) {
            //제거할 데이터가 현재 노드보다 작은경우 왼쪽 자식노드에 있고

            if (targetRootNode.getLeftSubTree() != null) {
                //그리고 현재 노드의 왼쪽 자식 노드가 존재하는 경우

                targetRootNode.setLeftSubTree(this.remove(targetRootNode.getLeftSubTree(), data, parentNode));
                //제거를 하면 제거된 노드를 대체하는 자식 노드가 리턴됨
            }
        } else if (targetRootNode.getData().compareTo(data) > 0) {
            //제거할 데이터가 현재 노드보다 큰 경우 오른쪽 자식노드에 있고

            if (targetRootNode.getRightSubTree() != null) {
                //그리고 현재 노드의 오른쪽 자식 노드가 존재하는 경우

                targetRootNode.setRightSubTree(this.remove(targetRootNode.getRightSubTree(), data, parentNode));
            }
        } else if (targetRootNode.getData().equals(data)) {
            //현재 노드가 제거할 데이터와 같은 경우. 즉 삭제할 노드를 찾은 경우
            targetRootNode = this.removeHelper(targetRootNode, parentNode);

            if (parentNode == null && targetRootNode != null) {
                this.updateHeight(targetRootNode);
                BinaryTree<T> unBalanceNode = this.getUnBalanceNode(targetRootNode);
                targetRootNode = this.rotation(targetRootNode, unBalanceNode.getData());
                //루트노드를 삭제하는 경우 아래 코드가 실행되지 않기 때문에 여기서 기저조건으로 아래 코드 실행해줌
            }

            return targetRootNode;
        }

        this.updateHeight(targetRootNode);
        //인서트 함수에선 삽입하는 노드가 균형을 무너뜨리므로 바로 회전하면 되지만, 리무브에선 균형 체크를 해봐야함
        BinaryTree<T> unBalanceNode = this.getUnBalanceNode(targetRootNode);
        targetRootNode = this.rotation(targetRootNode, unBalanceNode.getData());
        return targetRootNode;
    }

    private BinaryTree<T> removeHelper(BinaryTree<T> deletingNode, BinaryTree<T> parentNode) {

        BinaryTree<T> fakeParentRootNode = new BinaryTree<>(null);
        fakeParentRootNode.setLeftSubTree(this.root);

        if (parentNode == null) {
            parentNode = fakeParentRootNode;
        }

        BinaryTree<T> deletingNodeChild = null;

        if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree();
            } else {
                parentNode.removeRightSubTree();
            }
        } else if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {

            //제거할 노드가 자식이 하나 있는 경우


            if (deletingNode.getLeftSubTree() != null) {
                deletingNodeChild = deletingNode.getLeftSubTree();
            } else {
                deletingNodeChild = deletingNode.getRightSubTree();
            }

            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.setLeftSubTree(deletingNodeChild);
            } else {
                parentNode.setRightSubTree(deletingNodeChild);
            }
        } else {
            //자식 노드가 두개 있는 경우

            BinaryTree<T> replacingNode = deletingNode.getLeftSubTree();
            BinaryTree<T> replacingNodeParent = deletingNode;

            while (replacingNode.getRightSubTree() != null) {
                replacingNodeParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            T deletingNodeData = deletingNode.getData();
            deletingNode.setData(replacingNode.getData());

            if (replacingNodeParent.getLeftSubTree() == replacingNode) {
                replacingNodeParent.setLeftSubTree(replacingNode.getLeftSubTree());
            } else {
                replacingNodeParent.setRightSubTree(replacingNode.getLeftSubTree());
            }
            deletingNodeChild = deletingNode;
        }
        if (fakeParentRootNode.getLeftSubTree() != this.root) {
            this.root = fakeParentRootNode.getLeftSubTree();
        }

        return deletingNodeChild;
    }

    private BinaryTree<T> insert(BinaryTree<T> targetRootNode, T data) {
        //최초에 삽입하는 경우나 터미널 노드로 삽입하는 경우
        if (targetRootNode == null) {
            targetRootNode = new BinaryTree<>(data);
        }

        // avl 트리에 처음 뎅터를 삽입하는 경우 새로 만든 노드를 루트노드로 설정
        if (this.root == null) {    
            this.root = targetRootNode;
        } else if (targetRootNode.getData().equals(data)) {
            //중복데이터 허용 안하기에 바로 함수 종료
            return targetRootNode;
        } else if (targetRootNode.getData().compareTo(data) > 0) {
            //기존 데이터가 삽입하려는 데이터보다 클 경우
            targetRootNode.setLeftSubTree(
                    this.insert(targetRootNode.getLeftSubTree(), data));
        } else {
            //기존 데이터가 삽입하려는 데이터보다 작은 경우
            targetRootNode.setRightSubTree(this.insert(targetRootNode.getRightSubTree(), data));
        }

        this.updateHeight(targetRootNode);
        targetRootNode = this.rotation(targetRootNode, data);

        return targetRootNode;
    }



    //밸런스 점검을 위해 높이 구하기
    private int getHeight(BinaryTree<T> node) {
        if (node == null) {
            return 0;
        } else {
            return node.getHeight();
        }
    }

    //RR, LL등 로테이션후 높이 업데이트
    private void updateHeight(BinaryTree<T> node) {
        int leftChildHeight = this.getHeight(node.getLeftSubTree());
        int rightChildHeight = this.getHeight(node.getRightSubTree());

        node.setHeight(Math.max(leftChildHeight, rightChildHeight) + 1);
    }

    private int getBalanceFactor(BinaryTree<T> node) {

        return this.getHeight(node.getLeftSubTree()) - this.getHeight(node.getRightSubTree());
        //리턴 값이 양수라면 왼쪽 노드의 높이가 더 높은것
    }

    /*
      1
       \
        3
         \
          5
      이런식으로 오른쪽으로 불균형하게 뻗은 경우 1을 왼쪽회전...
       3
      / \
     1   5
    */
    private BinaryTree<T> rotateLeft(BinaryTree<T> node) {
        BinaryTree<T> childNode = node.getRightSubTree();

        //로테이트할 노드의 오른쪽 자식노드가 자식을 가지고 있을 경우 잃어버리지 않게 로테이트할 노드의 오른쪽으로 붙혀줌. (이진탐색트리 특성상 오른쪽자식의 자식은 무조건 부모노드보다 클거라 오른쪽으로 붙혀주면 됨)
        node.setRightSubTree(childNode.getLeftSubTree());

        //이제 로테이트할 노드를 자식노드 왼쪽으로 붙혀주면, 왼쪽 회전한것
        childNode.setLeftSubTree(node);

        //회전하면서 로테이트한 노드와, 원래 자식이였던 노드의 높이가 변했으니, 높이 업데이트해줌.

        this.updateHeight(node);
        this.updateHeight(childNode);

        return childNode;
    }

    //RR 회전은 위 LL 회전 반대
    private BinaryTree<T> rotateRight(BinaryTree<T> node) {
        BinaryTree<T> childNode = node.getLeftSubTree();

        node.setLeftSubTree(childNode.getRightSubTree());

        childNode.setRightSubTree(node);

        updateHeight(node);
        updateHeight(childNode);

        return childNode;
    }

    /*
       1 targetNode
        \
         3
          \
           5 data(균형을 무너뜨린 노드의 값)

     */

    private BinaryTree<T> rotation(BinaryTree<T> targetNode, T data) {

        //타겟노드의 왼쪽 높이 - 오른쪽 높이 계산해서 높이차가 2 이상이면 균형 깨진 상황. avl_tree 에선 높이차 1까진 균형잡힌 것으로 봄.
        int balanceFactor = this.getBalanceFactor(targetNode);

        //루트 노드가 회전하는 경우, avl 트리의 루트 노드를 가리키는 변수를 새로 루트노드가 된 노드로 변경해야 하니, 루트노드인지 체크
        boolean isRootNode = false;
        if (targetNode == this.root) {
            isRootNode = true;
        }

        // 회전 처리
        if (balanceFactor < -1) {
            //불균형이 오른쪽에서 발생하고

            if (data.compareTo(targetNode.getRightSubTree().getData()) > 0) {
                //오른쪽으로 쭉 뻗은 경우로 LL 회전 필요

                targetNode = this.rotateLeft(targetNode);
            } else {
                //오른쪽으로 가다 왼쪽으로 꺾인 경우로 RL 회전 필요

                //우선 오른쪽으로 쭉 펴고
                targetNode.setRightSubTree(this.rotateRight(targetNode.getRightSubTree()));

                //그걸 LL 회전
                targetNode = this.rotateLeft(targetNode);
            }

        } else if (balanceFactor > 1) {
            //불균형이 왼쪽에서 발생하고
            if (data.compareTo(targetNode.getLeftSubTree().getData()) < 0) {
                //왼쪽으로 쭉 뻗은 경우로 RR 회전 필요

                targetNode = this.rotateRight(targetNode);
            } else {
                //왼쪽으로 가다 오른쪽으로 꺾인 경우로 LR 회전 필요

                //우선 왼쪽으로 쭉 펴주고
                targetNode.setLeftSubTree(this.rotateLeft(targetNode.getLeftSubTree()));

                //그걸 RR 회전
                targetNode = this.rotateRight(targetNode);
            }
        }

        if (isRootNode) {
            this.root = targetNode;
        }

        return targetNode;
    }

    //insert 경우엔 어차피 균형을 무너 뜨리기 때문에 따로 불균형체크할 필요 없지만, remove 시엔 제거후 불균형한지 체크해줘야함.
    /*
        3 targetRootNode
       / \
      1   5
    (제거)  \
            7 data (1 제거후 얘가 균형을 무너뜨림)
     여기에서 1 제거시 불균형해짐. 이때 저 7을 지정해주는 함수.
     */
    private BinaryTree<T> getUnBalanceNode(BinaryTree<T> targetRootNode) {
        BinaryTree<T> unBalanceNode;

        if (targetRootNode.getLeftSubTree() == null && targetRootNode.getRightSubTree() == null) {
            //자식 노드가 없는 경우. 즉 터미널 노드인 경우

            unBalanceNode = targetRootNode;
            return unBalanceNode;
        }

        int balanceFactor = this.getBalanceFactor(targetRootNode);
        if (balanceFactor > 0) {
            unBalanceNode = this.getUnBalanceNode(targetRootNode.getLeftSubTree());
        } else if (balanceFactor < 0) {
            unBalanceNode = this.getUnBalanceNode(targetRootNode.getRightSubTree());
        } else {
            unBalanceNode = targetRootNode.getRightSubTree();
        }

        return unBalanceNode;
    }
}