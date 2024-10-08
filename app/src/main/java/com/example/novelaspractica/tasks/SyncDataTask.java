package com.example.novelaspractica.tasks;

import android.os.AsyncTask;
import android.content.Context;

import com.example.novelaspractica.utils.NotificationHelper;

public class SyncDataTask extends AsyncTask<Void, Void, String> {
    private Context context;

    // Constructor
    public SyncDataTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Simular la sincronización de datos
        return "Sincronización completada";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Mostrar una notificación al terminar la sincronización
        NotificationHelper.createNotificationChannel(context);  // Crear canal
        NotificationHelper.showNotification(context, result);   // Mostrar notificación
    }
}
