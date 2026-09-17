package selenium.advance.KeywordsDemoTwo;

public class KeywordExecution {
    KeywordsImpl k = new KeywordsImpl();

    public void exe(String keyword) throws Exception
    {
        if(keyword.equals("launch"))
        {
            k.openbrowser();
        }
        if(keyword.equals("url"))
        {
            k.openurl();
        }
        if(keyword.equals("creds"))
        {
            k.credsenter();
        }
        if(keyword.equals("login"))
        {
            k.loginclick();
        }
        if(keyword.equals("close"))
        {
            k.close();
        }
    }
}
