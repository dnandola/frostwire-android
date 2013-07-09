/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011, 2012, 2013, FrostWire(R). All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.frostwire.vuze;

import java.util.List;
import java.util.concurrent.Future;

import org.gudy.azureus2.core3.download.DownloadManager;
import org.gudy.azureus2.core3.global.GlobalManager;

import com.aelitis.azureus.core.AzureusCore;
import com.frostwire.concurrent.AsyncFuture;

/**
 * Class to initialize the azureus core.
 * 
 * @author gubatron
 * @author aldenml
 *
 */
public final class VuzeManager {

    private final VuzeEngine engine;

    private VuzeManager() {
        this.engine = new VuzeEngine();
    }

    private static class Loader {
        static VuzeManager INSTANCE = new VuzeManager();
    }

    public static VuzeManager getInstance() {
        return Loader.INSTANCE;
    }

    public void start() {
        engine.start();
    }

    public AsyncFuture<List<DownloadManager>> getDownloadManagers() {
        return engine.getDownloadManagers();
    }

    public AzureusCore getAzureusCore() {
        return engine.getCore();
    }

    public AsyncFuture<AzureusCore> getCore() {
        return engine.getCore2();
    }

    GlobalManager getGlobalManager() {
        return engine.getGlobalManager();
    }
}