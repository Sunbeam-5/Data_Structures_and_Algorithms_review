package structure;

public class Table {
        public static final int Size = 10;
        public int [] head;
        public int length;
        public int size;

        //初始化
        public static void initTable(Table t) {
            t.head = new int[Size];
            if (t.head == null) {
                System.out.println("初始化失败");
                System.exit(0);
            }
            //空表初始化长度为0
            t.length = 0;
            //空表初始化存储空间
            t.size = Size;
        }

        public static void disPlayTable(Table t) {
            for (int i = 0; i < t.length; i++) {
                System.out.println(t.head[i]);
            }
        }

    public static void main(String[] args) {
        Table t = new Table();
        initTable(t);
        //存入数据
        for (int i = 0; i < Size; i++) {
            t.head[i] = i + 1;
            t.length++;
        }
        disPlayTable(t);
    }
}


