package _01_data_structure._02_non_linear._04_red_black_tree;

public class NilNode<T> extends BinaryTree<T>{
    private static final NilNode<?> INSTANCE = new NilNode<>();

    private NilNode() {
        super(null);
        this.setColor(Color.BLACK);
    }

    @SuppressWarnings("unchecked")
    public static <T> NilNode<T> getInstance() {
        return (NilNode<T>) INSTANCE;
    }
}
