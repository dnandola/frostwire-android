/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011, 2012, 2013, FrostWire(TM). All rights reserved.
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

package com.frostwire.bittorrent;

import java.io.File;

import org.gudy.azureus2.core3.config.COConfigurationManager;
import org.gudy.azureus2.core3.util.SystemProperties;

import com.aelitis.azureus.core.AzureusCore;
import com.aelitis.azureus.core.AzureusCoreFactory;
import com.aelitis.azureus.core.AzureusCoreLifecycleAdapter;
import com.frostwire.android.gui.util.SystemUtils;

/**
 * @author gubatron
 * @author aldenml
 *
 */
final class VuzeEngine implements BTorrentEngine {

    private final AzureusCore core;

    public VuzeEngine() {
        this.core = AzureusCoreFactory.create();
        this.core.addLifecycleListener(new CoreLifecycleAdapter());

        initConfiguration();
    }

    public AzureusCore getCore() {
        return core;
    }

    public void start() {
        core.start();
    }

    public void pause() {

    }

    public void resume() {

    }

    private void initConfiguration() {
        File azureusPath = SystemUtils.getAzureusDirectory();

        System.setProperty("azureus.config.path", azureusPath.getAbsolutePath());
        System.setProperty("azureus.install.path", azureusPath.getAbsolutePath());
        System.setProperty("azureus.loadplugins", "0"); // disable third party azureus plugins

        SystemProperties.APPLICATION_NAME = "azureus";
        SystemProperties.setUserPath(azureusPath.getAbsolutePath());

        COConfigurationManager.setParameter(VuzeKeys.AUTO_ADJUST_TRANSFER_DEFAULTS, false);
        COConfigurationManager.setParameter(VuzeKeys.RESUME_DOWNLOADS_ON_START, true);
        COConfigurationManager.setParameter(VuzeKeys.GENERAL_DEFAULT_TORRENT_DIRECTORY, SystemUtils.getTorrentsDirectory().getAbsolutePath());
    }

    private class CoreLifecycleAdapter extends AzureusCoreLifecycleAdapter {
        @Override
        public void started(AzureusCore core) {
            // do something?
        }
    }
}
