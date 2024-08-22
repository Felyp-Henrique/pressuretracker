package com.github.felyphenrique.tracker.application.ping.proxies;

import com.github.felyphenrique.tracker.application.ping.entities.Ping;

public class PingProxy {
    private Ping ping;

    public PingProxy(final Ping ping) {
        this.ping = ping;
    }

    public Ping getPing() {
        return ping;
    }

    public void setPing(Ping ping) {
        this.ping = ping;
    }
}
