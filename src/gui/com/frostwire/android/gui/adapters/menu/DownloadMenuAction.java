/*
 * Created by Angel Leon (@gubatron), Alden Torres (aldenml)
 * Copyright (c) 2011, 2012, FrostWire(TM). All rights reserved.
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

package com.frostwire.android.gui.adapters.menu;

import android.content.Context;

import com.frostwire.android.R;
import com.frostwire.android.core.FileDescriptor;
import com.frostwire.android.gui.Peer;
import com.frostwire.android.gui.transfers.TransferManager;
import com.frostwire.android.gui.util.UIUtils;
import com.frostwire.android.gui.views.AbstractListAdapter;
import com.frostwire.android.gui.views.MenuAction;

/**
 * @author gubatron
 * @author aldenml
 *
 */
public class DownloadMenuAction extends MenuAction {

    private final AbstractListAdapter<?> adapter;
    private final Peer peer;
    private final FileDescriptor fd;

    public DownloadMenuAction(Context context, AbstractListAdapter<?> adapter, Peer peer, FileDescriptor fd) {
        super(context, R.drawable.download_icon, fd.title);

        this.adapter = adapter;
        this.peer = peer;
        this.fd = fd;
    }

    @Override
    public void onClick() {
        TransferManager.instance().download(peer, fd);
        adapter.notifyDataSetChanged();
        UIUtils.showLongMessage(getContext(), R.string.download_added_to_queue);
    }
}
