package joop.stack;
/*    Тестирование стека
*    с "черным списком" классов
*/

import java.util.Arrays;

public class HomeW20062 {
    public static void main(String[] args){
        Box box1 = new Box(5,4,5,1);
        Box box2 = new Box(2,2,2,0.3);
        Sphere sp1 = new Sphere(2,1);
        Sphere sp2 = new Sphere(3,1.5);
        Envelope env = new Envelope(0.21,0.27,0.01);
        Class clBox = box1.getClass();
        Class clSphere = sp1.getClass();
        BlackList bl1 = new BlackList(new Class[]{clSphere});
        System.out.println(Arrays.toString(bl1.getBlackList()));
        StackOb st = new StackOb(bl1);

        st.printStack();
        st.push(env);
        st.printStack();
        st.push(box1);
        st.printStack();
        st.push(sp2); // Класс Sphere внесен в "черный список"
        st.printStack();
        st.push(box2);
        st.printStack();
        st.push(sp1); // Класс Sphere внесен в "черный список"
        st.printStack();
        System.out.println("pop -> " + st.pop());
        st.printStack();
        System.out.println("peek -> " + st.peek());
        st.printStack();
        System.out.println("pop -> " + st.pop());
        st.printStack();
        System.out.println("pop -> " + st.pop());
        st.printStack();
        System.out.println("pop -> " + st.pop());
        st.printStack();

    }
}
