package android.curso.com.br.meusclientes.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by root on 21/05/15.
 */
public class MeusClientesBD extends SQLiteOpenHelper {

    // Nome e versão do banco
    private final static int VERSAO = 1;
    private final static String NOME_BD = "clientes_db";

    // Nome das tabelas
    public static String CLIENTE_TB = "cliente_tb";
    public static String PRODUTO_TB = "produto_tb";
    public static String CLIENTE_PRODUTO_TB = "cliente_produto+tb";

    // Colunas das tabelas
    public final static String[] CLIENTE_COLS = {"id", "nome", "clienteAtivo"};
    public final static String[] PRODUTO_COLS = {"id", "nome", "valor"};

    // DLL das tabelas
    public final static String CRIA_TABELA_CLIENTE = "CREATE TABLE" + CLIENTE_TB + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, ";

    public final static String CRIA_TABELA_PRODUTO = "CREATE TABLE" + PRODUTO_TB + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "valor FLOAT NOT NULL);";

    public final static String CRIA_TABELA_CLIENTE_PRODUTO = "CREATE TABLE" +
            CLIENTE_PRODUTO_TB + "(" +
            "id_cliente INTEGER NOT NULL, " +
            "id_produto INTEGER NOT NULL, " +
            "FOREIGN KEY (id_cliente) REFERENCES" + CLIENTE_TB + "(id)," +
            "FOREIGN KEY (id_produto) REFERENCES" + PRODUTO_TB + "(id);";


    // Variável de instacia
    private static MeusClientesBD instancia;

    private MeusClientesBD(Context context) {
        super(context, NOME_BD, null, VERSAO);
        Log.i("CLIENTES_BD", "Banco criado ou acessado com sucesso");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys = ON");
        Log.i("MEUSCLIENTES_BD", "Chaves estrangeiras liberadas");

        db.execSQL(CRIA_TABELA_CLIENTE);
        Log.i("MEUSCLIENTES_BD", "Tabela cliente");

        db.execSQL(CRIA_TABELA_PRODUTO);
        Log.i("MEUSCLIENTES_BD", "Tabela produto");

        db.execSQL(CRIA_TABELA_CLIENTE_PRODUTO);
        Log.i("MEUSCLIENTES_BD", "Tabela cliente_produto");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Nesse método vc faz operações ao atualizar o esquema do banco
    }

    public static MeusClientesBD getInstancia(Context context) {

        if (instancia == null) {
            instancia = new MeusClientesBD(context);
        }
        return instancia;
    }
}
