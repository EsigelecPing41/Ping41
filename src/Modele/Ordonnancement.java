package Modele;
import java.util.Date;

public class Ordonnancement
{
    private int Ord_ID;
    private String Ord_Designation;
    private int Ord_QteFab;
    private String Ord_Ste;
    private String Ord_CodeClient;
    private Date Ord_DelaiCde;
    private Date Ord_MFab;
    private Date Ord_DelaiPrv;
    private Date Ord_DelaiDde;
    private String Ord_FamGest;
    private String Ord_NumDossier;
    private String Ord_CodeGPAO;
    private String Ord_IndNomenclature;
    private String Ord_NumSerie;
    private String Ord_ComInterne;

    public int getOrd_ID() 
    {
        return this.Ord_ID;
    }

    public void setOrd_ID(final int value) 
    {
        this.Ord_ID = value;
    }

    public String getOrd_Designation()
    {
        return this.Ord_Designation;
    }

    public int getOrd_QteFab()
    {
        return this.Ord_QteFab;
    }

    public String getOrd_Ste()
    {
        return this.Ord_Ste;
    }

    public String getOrd_CodeClient() 
    {
        return this.Ord_CodeClient;
    }

    public Date getOrd_DelaiCde() 
    {
        return this.Ord_DelaiCde;
    }

    public Date getOrd_MFab()
    {
        return this.Ord_MFab;
    }

    public Date getOrd_DelaiPrv() 
    {
        return this.Ord_DelaiPrv;
    }

    public Date getOrd_DelaiDde() 
    {
        return this.Ord_DelaiDde;
    }
    public String getOrd_FamGest() 
    {
        return this.Ord_FamGest;
    }
    public String getOrd_NumDossier() 
    {
        return this.Ord_NumDossier;
    }

    public String getOrd_CodeGPAO() 
    {
        return this.Ord_CodeGPAO;
    }

    public String getOrd_IndNomenclature() 
    {
        return this.Ord_IndNomenclature;
    }

    public String getOrd_NumSerie() 
    {
        return this.Ord_NumSerie;
    }
    public String getOrd_ComInterne()
    {
        return this.Ord_ComInterne;
    }

    public void setOrd_Designation(final String value)
    {
        this.Ord_Designation = value;
    }

    public void setOrd_QteFab(final int value)
    {
        this.Ord_QteFab = value;
    }

    public void setOrd_Ste(final String value)
    {
        this.Ord_Ste = value;
    }

    public void setOrd_CodeClient(final String value)
    {
        this.Ord_CodeClient = value;
    }

    public void setOrd_DelaiCde(final Date value) 
    {
        this.Ord_DelaiCde = value;
    }

    public void setOrd_MFab(final Date value) 
    {
        this.Ord_MFab = value;
    }

    public void setOrd_DelaiPrv(final Date value)
    {
    }

    public void setOrd_DelaiDde(final Date value)
    {
        this.Ord_DelaiDde = value;
    }

    public void setOrd_FamGest(final String value)
    {
        this.Ord_FamGest = value;
    }

    public void setOrd_NumDossier(final String value)
    {
        this.Ord_NumDossier = value;
    }

    public void setOrd_CodeGPAO(final String value) 
    {
        this.Ord_CodeGPAO = value;
    }

    public void setOrd_IndNomenclature(final String value)
    {
        this.Ord_IndNomenclature = value;
    }

    public void setOrd_NumSerie(final String value)
    {
        this.Ord_NumSerie = value;
    }

    public void setOrd_ComInterne(final String value)
    {
        this.Ord_ComInterne = value;
    }

    public void LancerFicheSuiveuse()
    {
    }

    public void LancerListeManquante()
    {
    }

    public void LancerPvControle() 
    {
    }

    public void LancerListeAServir() 
    {
    }

}
