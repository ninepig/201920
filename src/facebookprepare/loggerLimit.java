package facebookprepare;

/**
 * Created by yangw on 2019/7/2.
 */
public class loggerLimit {
    class Logger {
        class TimedMessage {
            public int timestamp;
            public String message;

            public TimedMessage(int timestamp, String message) {
                this.timestamp = timestamp;
                this.message = message;
            }
        }

        Queue<TimedMessage> queue;
        Set<String> messages;

        /** Initialize your data structure here. */
        public Logger() {
            queue = new LinkedList<TimedMessage>();
            messages = new HashSet<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            while(!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10) {
                String msg = queue.remove().message;
                messages.remove(msg);
            }
            if(messages.contains(message)) {
                return false;
            } else {
                queue.offer(new TimedMessage(timestamp, message));
                messages.add(message);
                return true;
            }
        }
    }
}
