package algorithm;

import java.util.LinkedList;

/**
 * @desc 两个队列模拟栈
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/11.
 */
public class TwoQueue<T> {
    private LinkedList<T> queue1 = new LinkedList<>();
    private LinkedList<T> queue2 = new LinkedList<>();
    public T pop() {
        T re = null;
        if(queue1.size() == 0 && queue2.size() == 0) {
            return null;
        } if(queue2.size() == 0) {
            while(queue1.size() > 0) {
                re = queue1.removeFirst();
                if(queue1.size() != 0) {
                    queue2.addLast(re);
                }
            }
        } else if(queue1.size() == 0) {
            while(queue2.size() > 0) {
                re = queue2.removeFirst();
                if(queue2.size() != 0) {
                    queue1.addLast(re);
                }
            }
        } return re;
    }
    public void push(T t) {
        if(queue1.size() == 0 && queue2.size() == 0) {
            queue1.addLast(t);
        } if(queue1.size() != 0) {
            queue1.addLast(t);
        } else if(queue2.size() != 0) {
            queue2.addLast(t);
        }
    }
}
