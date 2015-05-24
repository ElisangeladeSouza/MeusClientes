package android.curso.com.br.meusclientes.adapter;

import android.content.Context;
import android.curso.com.br.meusclientes.R;
import android.curso.com.br.meusclientes.model.Cliente;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 19/05/15.
 */
public class ClienteAdapter extends BaseAdapter {

    List<Cliente> clientes;
    LayoutInflater inflater;
    Context context;

    public ClienteAdapter(Context context, List<Cliente> clientes) {
        this.clientes = clientes;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        ViewHolder holder;

        if (convertView == null) {
            v = inflater.inflate(R.layout.list_item_cliente, parent, false);
            holder = new ViewHolder();
            holder.tvNomeCliente = (TextView) v.findViewById(R.id.tv_lv_nome_cliente);
            holder.tvNomeProduto = (TextView) v.findViewById(R.id.tv_lv_nome_produto);
            holder.tvValor = (TextView) v.findViewById(R.id.tv_lv_valor);

        } else {
            v = convertView;
            holder = (ViewHolder) v.getTag();
        }

        Cliente cliente = clientes.get(position);
        holder.tvNomeCliente.setText(cliente.getNome());


        return v;
    }

    public class ViewHolder {
        public TextView tvNomeCliente;
        public TextView tvNomeProduto;
        public TextView tvValor;
    }
}
