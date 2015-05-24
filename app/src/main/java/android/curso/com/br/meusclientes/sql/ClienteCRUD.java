package android.curso.com.br.meusclientes.sql;

import android.content.ContentValues;
import android.content.Context;
import android.curso.com.br.meusclientes.model.Cliente;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by root on 19/05/15.
 */
public class ClienteCRUD {

    private Context context;

    public ClienteCRUD(Context context) {
        MeusClientesBD.getInstancia(context);
        this.context = context;
    }

    public void criar (Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put(MeusClientesBD.CLIENTE_COLS[1], cliente.getNome());
        values.put(MeusClientesBD.CLIENTE_COLS[2], cliente.isClienteAtivo());

        MeusClientesBD.getInstancia(context).getWritableDatabase().insert(
                MeusClientesBD.CLIENTE_TB, null, values);

    }

    public void remover (Cliente cliente) {
        int idCliente = cliente.getId();
        MeusClientesBD.getInstancia(context).getWritableDatabase().
                delete(MeusClientesBD.CLIENTE_TB,
                        MeusClientesBD.CLIENTE_COLS[0] + " = " + idCliente, null);
    }

    public void atualizar (Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put(MeusClientesBD.CLIENTE_COLS[1], cliente.getNome());
        values.put(MeusClientesBD.CLIENTE_COLS[2], cliente.isClienteAtivo());

        MeusClientesBD.getInstancia(context).getWritableDatabase().
                update(MeusClientesBD.CLIENTE_TB, values,
                        MeusClientesBD.CLIENTE_COLS[0] + " = " +
                                cliente.getId(), null);
    }

    public ArrayList<Cliente> buscaPorId(int id) {
        Cursor cursor = MeusClientesBD.getInstancia(context).
        getReadableDatabase().query(MeusClientesBD.CLIENTE_TB,
        MeusClientesBD.CLIENTE_COLS, MeusClientesBD.CLIENTE_COLS[0]+ " = "+
        id, null, null, null, null);

        ArrayList<Cliente> clientes = new ArrayList<>();

        cursor.moveToFirst();
        while (cursor.moveToFirst()) {
            clientes.add(cursorParaCliente(cursor));
        }

        return clientes;

    }

    public Cliente cursorParaCliente(Cursor cursor) {
        Cliente cliente = new Cliente();

        cliente.setId(cursor.getInt(0));
        cliente.setNome(cursor.getString(1));

        if (cursor.getInt(2) == 1) {
            cliente.setClienteAtivo(true);
        } else if (cursor.getInt(2) == 0) {
            cliente.setClienteAtivo(false);
        }

        return cliente;

    }





}
