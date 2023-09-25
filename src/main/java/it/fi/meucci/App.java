package it.fi.meucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ServerStr mioServer = new ServerStr();
        mioServer.attendi();
        mioServer.comunica();
    }
}
