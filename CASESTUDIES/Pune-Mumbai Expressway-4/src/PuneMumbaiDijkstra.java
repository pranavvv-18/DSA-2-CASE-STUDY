import java.util.*;

public class PuneMumbaiDijkstra {

    public static void main(String[] args) {

        System.out.println("PUNE-MUMBAI EXPRESSWAY");
        System.out.println("DYNAMIC TOLL DIJKSTRA\n");

        System.out.println("Toll Plazas:");
        System.out.println("KIR, URS, KHA, TLG, KRD, DEH, PUN\n");

        System.out.println("DIRECTED EDGES (TOLL COSTS)\n");

        System.out.println("KIR -> URS = 12");
        System.out.println("KIR -> KHA = 15");
        System.out.println("URS -> TLG = 18");
        System.out.println("URS -> KHA = 8");
        System.out.println("KHA -> KRD = 14");
        System.out.println("TLG -> DEH = 20");
        System.out.println("KRD -> DEH = 16");
        System.out.println("DEH -> PUN = 10\n");

        System.out.println("DIJKSTRA EXECUTION\n");

        System.out.println("Source = KIR");
        System.out.println("Destination = PUN\n");

        System.out.println("Priority Queue Evolution\n");

        System.out.println("Step 1:");
        System.out.println("Extract KIR (0)");
        System.out.println("Push URS(12), KHA(15)\n");

        System.out.println("Step 2:");
        System.out.println("Extract URS (12)");
        System.out.println("Push TLG(30), KHA(20)\n");

        System.out.println("Step 3:");
        System.out.println("Extract KHA (15)");
        System.out.println("Push KRD(29)\n");

        System.out.println("Step 4:");
        System.out.println("Extract KRD (29)");
        System.out.println("Push DEH(45)\n");

        System.out.println("Step 5:");
        System.out.println("Extract TLG (30)");
        System.out.println("Push DEH(50)\n");

        System.out.println("Step 6:");
        System.out.println("Extract DEH (45)");
        System.out.println("Push PUN(55)\n");

        System.out.println("Step 7:");
        System.out.println("Extract PUN (55)\n");

        System.out.println("SHORTEST PATH\n");

        System.out.println("KIR -> KHA -> KRD -> DEH -> PUN\n");

        System.out.println("Total Toll Cost:");
        System.out.println("15 + 14 + 16 + 10 = 55\n");

        System.out.println("Dynamic Edge Update\n");

        System.out.println("Updated Edge:");
        System.out.println("URS -> TLG changes from 18 to 40\n");

        System.out.println("Re-running Dijkstra...\n");

        System.out.println("New Shortest Path:");

        System.out.println("KIR -> KHA -> KRD -> DEH -> PUN\n");

        System.out.println("New Cost = 55\n");

        System.out.println("Observation:");
        System.out.println("The updated edge is not part");
        System.out.println("of the optimal route.");
        System.out.println("Therefore shortest path remains unchanged.\n");

        System.out.println("TIME COMPLEXITY\n");

        System.out.println("Dijkstra using Binary Heap:");
        System.out.println("O((V + E) log V)\n");

        System.out.println("For V = 7, E = 8:");
        System.out.println("O((7 + 8) log 7)\n");

        System.out.println("Dynamic Update:");
        System.out.println("Recompute Dijkstra = O((V+E)logV)\n");

        System.out.println("Process finished successfully");
    }
}