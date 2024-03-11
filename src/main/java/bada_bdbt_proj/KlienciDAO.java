package bada_bdbt_proj;

import java.beans.BeanProperty;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class KlienciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate1;

    public KlienciDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate1 = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Klienci> list() {
        String sql="SELECT * FROM KLIENCI";
        List<Klienci> listKlienci=jdbcTemplate1.query(sql, BeanPropertyRowMapper.newInstance(Klienci.class));

        return listKlienci;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klienci klienci) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate1);
        insertActor.withTableName("KLIENCI").usingColumns("id_klienta","imie","drugie_imie","nazwisko","pesel","numer_telefonu","email","id_salonu","numer_adresu");
        BeanPropertySqlParameterSource param1= new BeanPropertySqlParameterSource(klienci);
        insertActor.execute(param1);
    }

    /* Read – odczytywanie danych z bazy */
    public Klienci get(int id) {
        String sql = "SELECT * FROM KLIENCI WHERE id_klienta=?";
        Object[] args={id};
        Klienci klienci = jdbcTemplate1.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Klienci.class));
        return klienci;
    }
    /*public Oferta get(int id_pojazdu) {
        Object[] args={id_pojazdu};
        String sql = "SELECT * FROM POJAZDY WHERE ID_POJAZDU="+ args[0];

        Oferta oferta = jdbcTemplate.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Oferta.class));
        return oferta;
    }

    /* Update – aktualizacja danych */
    public void update(Klienci klienci) {
        String sql="UPDATE KLIENCI SET imie=:imie,drugie_imie=:drugie_imie,nazwisko=:nazwisko,pesel=:pesel,numer_telefonu=:numer_telefonu,email=:email,id_salonu=:id_salonu,numer_adresu=:numer_adresu,id_klienta=:id_klienta";
        BeanPropertySqlParameterSource param1 = new BeanPropertySqlParameterSource(klienci);
        NamedParameterJdbcTemplate template1 =  new NamedParameterJdbcTemplate(jdbcTemplate1);
        template1.update(sql,param1);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql="DELETE FROM KLIENCI WHERE ID_KLIENTA=?";
        jdbcTemplate1.update(sql,id);
    }

}
