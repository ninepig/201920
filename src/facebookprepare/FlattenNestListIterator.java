package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class FlattenNestListIterator {
    Stack<NestedInteger> stack ;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for(int i = nestedList.size()-1;i>=0 ; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // it must be a Integer ,because it will call has next before
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger first= stack.peek();
            if(first.isInteger()){
                return true;
            }
            stack.pop();
            for(int i = first.getList().size()-1;i>=0;i--){
                stack.push(first.getList().get(i));
            }
        }
        return false;
    }
}
