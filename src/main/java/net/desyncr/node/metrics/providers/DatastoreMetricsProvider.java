package net.desyncr.node.metrics.providers;

import freenet.support.*;
import net.desyncr.node.metrics.*;

import java.util.*;

public class DatastoreMetricsProvider extends DefaultMetricProvider implements Runnable, MetricsProvider {
    public DatastoreMetricsProvider(Ticker ticker) {
        super(ticker);
    }

    public List<Metric> update() {
        return null;
    }
}
