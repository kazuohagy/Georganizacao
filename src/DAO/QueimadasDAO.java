/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Queimadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kazuo
 */
public class QueimadasDAO implements Persistencia<Queimadas> {

    private static QueimadasDAO dao = null;

    public Queimadas[] mariolist = new Queimadas[860];

    public static QueimadasDAO getInstance() {
        if (dao == null) {
            dao = new QueimadasDAO();
        }
        return dao;

    }

    @Override
    public int create(Queimadas q) {
        int id = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "INSERT INTO focus_queimadas (datahora,satelite,pais,estado,municipio,bioma,diasemchuva,precipitacao,riscofogo,latitude,longitude,frp"
                + ") values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, q.getDatahora());
            pst.setString(1, q.getSatelite());
            pst.setString(1, q.getPais());
            pst.setString(1, q.getEstado());
            pst.setString(1, q.getMunicipio());
            pst.setString(1, q.getBioma());
            pst.setString(1, q.getDiasemchuva());
            pst.setString(1, q.getPrecipitacao());
            pst.setString(1, q.getRiscofogo());
            pst.setString(1, q.getLatitude());
            pst.setString(1, q.getLongitude());
            pst.setString(1, q.getFrp());
            pst.execute();
            rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            id = 0;
        } finally {
            ConnectionFactory.closeConnetion(con, pst, rs);
        }
        return id;
    }

    @Override
    public List<Queimadas> read() {
        int i = 0;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Queimadas> queimadas = new ArrayList();

        try {
            pst = con.prepareStatement("SELECT * FROM focus_queimadas order by Id DESC");
            rs = pst.executeQuery();
            while (rs.next()) {
                Queimadas queimada = new Queimadas();

                //queimada.setDatahora(rs.getString("Datahora") ==null ? "" : rs.getString("datahora"));
                queimada.setDatahora(rs.getString("Datahora"));
                queimada.setSatelite(rs.getString("Satelite"));
                queimada.setPais(rs.getString("Pais"));
                queimada.setEstado(rs.getString("Estado"));
                queimada.setMunicipio(rs.getString("Municipio"));
                queimada.setBioma(rs.getString("Bioma"));
                queimada.setDiasemchuva(rs.getString("Diasemchuva"));
                queimada.setPrecipitacao(rs.getString("Precipitacao"));
                queimada.setRiscofogo(rs.getString("Riscofogo"));
                queimada.setLatitude(rs.getString("Latitude"));
                queimada.setLongitude(rs.getString("Longitude"));
                queimada.setFrp(rs.getString("Frp"));
                queimada.setId(rs.getInt("Id"));
                queimadas.add(queimada);
                mariolist[i] = queimada;
                i++;

            }


        } catch (SQLException ex) {
            throw new RuntimeException("Erro no select.");
        } finally {
            ConnectionFactory.closeConnetion(con, pst, rs);
        }
        return queimadas;
    }

    @Override
    public boolean update(Queimadas obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Queimadas obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Queimadas findByCodigo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
