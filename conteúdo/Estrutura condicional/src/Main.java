//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ternaria();
    }

    public static void ternaria(){
        double preco = 34.5;
        double desconto;
//        if (preco < 20.0){
//            desconto = preco * 0.1;
//        } else {
//            desconto = preco * 0.05;
//        }

//        Outra forma:
        desconto = (preco < 20.0) ? preco * 0.1 : preco * 0.05;
        System.out.println(desconto);
    }
}