package net.desyncr.node.metrics;

import freenet.node.*;
import freenet.support.*;
import net.desyncr.node.metrics.persisters.*;
import net.desyncr.node.metrics.providers.*;

import java.util.*;

public class DefaultNodeMetrics implements NodeMetrics {
    private final List<MetricsProvider> providers = new ArrayList<>();
    private final NodeMetricsPersisterGraphite nodeMetricsPersister;

    public DefaultNodeMetrics(Node node) {
        PeerManager peers = node.peers;
        Ticker ticker = node.ticker;
        providers.add(new ActivityMetricsProvider(ticker));
        providers.add(new BandwidthMetricsProvider(node, ticker));
        providers.add(new DatastoreMetricsProvider(ticker));
        providers.add(new MemoryMetricsProvider(ticker));
        providers.add(new PeersMetricsProvider(peers, ticker));
        providers.add(new StatusMetricsProvider(ticker));

        nodeMetricsPersister = new NodeMetricsPersisterGraphite(providers, ticker);
    }

    public void start() {
        providers.forEach(MetricsProvider::start);
        nodeMetricsPersister.start();
    }
}
