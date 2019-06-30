package joop.stack;

public interface BlackListing {
    default Class[] getBlackList(){
        return null;
    }
    default int searchNull(){
        return -1;
    }
    default boolean searchBClass(Class sClass){
        return false;
    }
}
