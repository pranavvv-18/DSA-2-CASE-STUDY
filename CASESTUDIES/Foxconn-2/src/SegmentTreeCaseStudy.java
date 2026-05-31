class SegmentTree {

    int[] tree;
    int n;

    SegmentTree(int[] arr) {

        n = arr.length;
        tree = new int[4 * n];

        build(arr, 1, 0, n - 1);
    }

    void build(int[] arr, int node, int start, int end) {

        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);

        tree[node] = Math.max(tree[2 * node],
                tree[2 * node + 1]);
    }

    int queryMax(int node, int start, int end,
                 int l, int r) {

        if (r < start || end < l)
            return Integer.MIN_VALUE;

        if (l <= start && end <= r)
            return tree[node];

        int mid = (start + end) / 2;

        int left =
                queryMax(2 * node, start, mid, l, r);

        int right =
                queryMax(2 * node + 1,
                        mid + 1, end, l, r);

        return Math.max(left, right);
    }

    void update(int node, int start, int end,
                int idx, int value) {

        if (start == end) {

            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid)
            update(2 * node, start, mid,
                    idx, value);
        else
            update(2 * node + 1,
                    mid + 1, end,
                    idx, value);

        tree[node] =
                Math.max(tree[2 * node],
                        tree[2 * node + 1]);
    }
}

public class SegmentTreeCaseStudy {

    public static void main(String[] args) {

        int[] readings =
                {71, 73, 78, 75, 82, 79, 77, 80};

        SegmentTree st =
                new SegmentTree(readings);

        System.out.println(
                "FOXCONN FACTORY FLOOR");
        System.out.println(
                "Segment Tree for Sensor Range-Max Alerts\n");

        System.out.println(
                "Sensor Readings:");

        for (int x : readings)
            System.out.print(x + " ");

        System.out.println("\n");

        System.out.println(
                "SEGMENT TREE CONSTRUCTION\n");

        System.out.println(
                "ROOT [1..8] = 82\n");

        System.out.println(
                "RANGE MAX QUERY");

        System.out.println(
                "Query Range = [3..7]");

        int answer1 =
                st.queryMax(1, 0, 7,
                        2, 6);

        System.out.println(
                "Maximum Temperature = "
                        + answer1 + "°C\n");

        System.out.println(
                "POINT UPDATE");

        System.out.println(
                "Index 4 changes from 75°C to 88°C");

        readings[3] = 88;

        st.update(1, 0, 7,
                3, 88);

        System.out.println(
                "\nUPDATED SENSOR ARRAY");

        for (int x : readings)
            System.out.print(x + " ");

        System.out.println("\n");

        System.out.println(
                "RANGE MAX QUERY");

        System.out.println(
                "Query Range = [2..6]");

        int answer2 =
                st.queryMax(1, 0, 7,
                        1, 5);

        System.out.println(
                "Maximum Temperature = "
                        + answer2 + "°C\n");

        System.out.println(
                "TIME COMPLEXITY");

        System.out.println(
                "Segment Tree Construction: O(n)");

        System.out.println(
                "Range Maximum Query: O(log n)");

        System.out.println(
                "Point Update: O(log n)\n");

        System.out.println(
                "Process finished successfully");
    }
}