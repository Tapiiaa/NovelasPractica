package com.example.novelaspractica.tasks;
import android.os.AsyncTask;
import android.widget.Toast;
import android.content.Context;

public class SyncDataTask extends AsyncTask<Void, Void, String> {
    // Clase para hacer tareas en segundo plano

    private Context context;

    // Constructor
    public SyncDataTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Realizar la tarea de sincronización, simulación de servidor remoto
        // Aquí es donde se haría la conexión real
        return "Sincronización completada";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Mostrar mensaje de sincronización completada
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }
}
