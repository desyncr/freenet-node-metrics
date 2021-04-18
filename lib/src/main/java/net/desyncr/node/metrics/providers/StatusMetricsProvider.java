package net.desyncr.node.metrics.providers;

import freenet.support.*;
import net.desyncr.node.metrics.*;

import java.util.*;

public class StatusMetricsProvider extends DefaultMetricProvider implements Runnable, MetricsProvider {
    public StatusMetricsProvider(Ticker ticker) {
        super(ticker);
    }

    public List<Metric> update() {
        return null;
    }
}
