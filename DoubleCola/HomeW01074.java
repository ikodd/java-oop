package joop.collections;
/*
* Двойная кола для Шелдона, Леонарда, Воловица, Кутрапалли и Пенни
*/

public class HomeW01074{
    public static void main(String[] args){
        QMember qm1 = new QMember("Sheldon");
        QMember qm2 = new QMember("Leonard");
        QMember qm3 = new QMember("Volovitc");
        QMember qm4 = new QMember("Kutrapalli");
        QMember qm5 = new QMember("Penny");
        QMember[] q = {qm1,qm2,qm3,qm4,qm5};
        DoubleCola.dblCola(q,4);

    }
}
