public class Main {
    public static void main(String[] args) {
        //Test

        //Test ArrayListIntSet
//        IntSet s1 = new ArrayListIntSet(100);
//        IntSet s2 = new ArrayListIntSet(100);

//
//        for (int i=1; i<=5; i++)
//            s1.add(i);
//        System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());
//
//        for (int i=3; i<=7; i++)
//            s2.add(i);
//        System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());
//
//        IntSet s3 = s1.intersection(s2);
//        System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());
//
//        IntSet s4 = s2.intersection(s1);
//        System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());
//
//        System.out.println("s1.equals(s2) = " + s1.equals(s2));
//        System.out.println("s3.equals(s4) = " + s3.equals(s4));
//-------------------------------------------------------------------------------------------------
        //Test BooleanArrayIntSet

        IntSet s1 = new BooleanArrayIntSet(50);
        IntSet s2 = new BooleanArrayIntSet(50);
        System.out.println(s1.add(20));
        System.out.println(s1.add(25));
        System.out.println(s1.add(30));
        System.out.println(s1.add(35));
        System.out.println(s1.add(40));
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println(s2.add(40));
        System.out.println(s2.add(20));
        System.out.println( s2.add(30));
        System.out.println(s2.add(25));
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
        System.out.println(s2.add(35));
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));

    int n = 1000000;
    IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
    boolean tmp;

	System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
	for (int i=1; i<=n; i++)
    tmp = s.add(i);

	System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
	for (int i=1; i<=n; i++)
    tmp = s.add(i);

	System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
	for (int i=1; i<=n; i++)
    tmp = s.contains(i);

	System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
	for (int i=1; i<=n; i++)
    tmp = s.remove(i);
}
    }



