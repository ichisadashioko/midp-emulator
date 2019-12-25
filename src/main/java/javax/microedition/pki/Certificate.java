package javax.microedition.pki;

public interface Certificate {
    public String getIssuer();

    public long getNotAfter();

    public long getNotBefore();

    public String getSerialNumber();

    public String getSigAlgName();

    public String getSubject();

    public String getType();

    public String getVersion();
}