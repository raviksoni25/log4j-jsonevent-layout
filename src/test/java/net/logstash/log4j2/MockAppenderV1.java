package net.logstash.log4j2;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class MockAppenderV1 extends AppenderSkeleton {

    private static List<String> messages = new ArrayList<String>();

    public MockAppenderV1(Layout layout){
        this.layout = layout;
    }
    @Override
    protected void append(LoggingEvent event){
        messages.add(layout.format(event));
    }

    public void close(){
        messages.clear();
    }

    public boolean requiresLayout(){
        return true;
    }

    public static String[] getMessages() {
        return messages.toArray(new String[messages.size()]);
    }

    public void clear() {
        messages.clear();
    }
}
