/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.QueimadasDAO;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kazuo
 */
public class Queimadas {

    private String datahora;
    private String satelite;
    private String pais;
    private String estado;
    private String municipio;
    private String bioma;
    private String diasemchuva;
    private String precipitacao;
    private String riscofogo;
    private String latitude;
    private String longitude;
    private String frp;
    private int id;
    

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public String getSatelite() {
        return satelite;
    }

    public void setSatelite(String satelite) {
        this.satelite = satelite;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBioma() {
        return bioma;
    }

    public void setBioma(String bioma) {
        this.bioma = bioma;
    }

    public String getDiasemchuva() {
        return diasemchuva;
    }

    public void setDiasemchuva(String diasemchuva) {
        this.diasemchuva = diasemchuva;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    public String getRiscofogo() {
        return riscofogo;
    }

    public void setRiscofogo(String riscofogo) {
        this.riscofogo = riscofogo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getFrp() {
        return frp;
    }

    public void setFrp(String frp) {
        this.frp = frp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Object getCampo(String campo){
        switch(campo){
            case "Id": 
                return getId();
            case "Data": 
                return getDatahora();
            case "satelite":
                return getSatelite();
            case "pais":
                return getPais();
            case "estado":
                return getEstado();
            case "municipio":
                return getMunicipio();     
            case "bioma":
                return getBioma();
            case "diasSemChuva":
                return getDiasemchuva();
            case "preciptacao":
                return getPrecipitacao();
            case "riscoDeFogo":
                return getRiscofogo();
            case "Latitude":
                return getLatitude();
            case "Longitude":
                return getLongitude();
            case "Frp":
                return getFrp();
          
            default : 
                return null;
        }
        
        
    }
    

    
    public Queimadas() {

    }

    @Override
    public String toString() {
        return "Queimadas{" + "datahora=" + datahora + ", satelite=" + satelite + ", pais=" + pais + ", estado=" + estado + ", municipio=" + municipio + ", bioma=" + bioma + ", diasemchuva=" + diasemchuva + ", precipitacao=" + precipitacao + ", riscofogo=" + riscofogo + ", latitude=" + latitude + ", longitude=" + longitude + ", frp=" + frp + ", id=" + id + '}';
    }

    public Queimadas(String datahora, String satelite, String pais, String estado, String municipio, String bioma, String diasemchuva, String precipitacao, String riscofogo, String latitude, String longitude, String frp, int id) {
        setDatahora(datahora);
        setSatelite(satelite);
        setPais(pais);
        setEstado(estado);
        setMunicipio(municipio);
        setBioma(bioma);
        setDiasemchuva(diasemchuva);
        setPrecipitacao(precipitacao);
        setRiscofogo(riscofogo);
        setLatitude(latitude);
        setLongitude(longitude);
        setFrp(frp);
        setId(id);
        
    }



   /* private void gravar() {
        QueimadasDAO dao = new QueimadasDAO();
        int codigo = dao.create(this);
        if (codigo > 0) {
            setId(codigo);
        }

    }*/

    public static DefaultTableModel getTableModel() {
        List<Queimadas> lista = QueimadasDAO.getInstance().read();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Data");
        modelo.addColumn("Satelite");
        modelo.addColumn("Pais");
        modelo.addColumn("Estado");
        modelo.addColumn("Municipio");
        modelo.addColumn("Bioma");
        modelo.addColumn("Dia Sem Chuva");
        modelo.addColumn("Preciptação");
        modelo.addColumn("Risco de fogo");
        modelo.addColumn("Latitude");
        modelo.addColumn("Longitude");
        modelo.addColumn("Frp");
        for (Queimadas c : lista) {
            String[] mario = {c.getDatahora(), c.getSatelite(), c.getPais(), c.getEstado(), 
                c.getMunicipio(), c.getBioma(), c.getDiasemchuva(), c.getPrecipitacao(), c.getRiscofogo(),
                c.getLatitude(), c.getLongitude(), c.getFrp()};
            modelo.addRow(mario);
        }
        return modelo;
    }

}
