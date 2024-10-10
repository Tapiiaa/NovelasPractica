package com.example.novelaspractica;

import android.content.Context;
import android.os.AsyncTask;

public class SyncDataTask extends AsyncTask<Void, Void, Void> {
    private Context context;

    public SyncDataTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Simular la sincronización de datos con un servidor remoto
        try {
            Thread.sleep(2000); // Simulación de tiempo de sincronización
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Enviar una notificación cuando la sincronización se complete
        com.example.novelaspractica.NotificationHelper.notifySyncComplete(context);
    }
}

