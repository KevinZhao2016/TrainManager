package com.service.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathSearchServerImplTest {
    private PathSearchServerImpl pathSearchServer = new PathSearchServerImpl();
    @Test
    public void getPaths() {
        pathSearchServer.getPaths("A","B");
    }
}