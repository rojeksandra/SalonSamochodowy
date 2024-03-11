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
public class OfertaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OfertaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    /* Import java.util.List */
    public List<Oferta> list() {
        String sql="SELECT * FROM POJAZDY";
        List<Oferta> listOferta=jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Oferta.class));

        return listOferta;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Oferta oferta) {
        SimpleJdbcInsert insertActor= new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("POJAZDY").usingColumns("id_pojazdu","numer_vin","marka","model","rok_produkcji","numer_rejestracyjny","przebieg","rodzaj_paliwa","kolor","moc_silnika","pojemnosc_bagaznika","cena","id_salonu");
        BeanPropertySqlParameterSource param= new BeanPropertySqlParameterSource(oferta);
        insertActor.execute(param);
    }

    /* Read – odczytywanie danych z bazy */
    public Oferta get(int id) {
        String sql = "SELECT * FROM POJAZDY WHERE id_pojazdu=?";
        Object[] args={id};
        Oferta oferta = jdbcTemplate.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Oferta.class));
        return oferta;
    }
    /*public Oferta get(int id_pojazdu) {
        Object[] args={id_pojazdu};
        String sql = "SELECT * FROM POJAZDY WHERE ID_POJAZDU="+ args[0];

        Oferta oferta = jdbcTemplate.queryForObject(sql,args,BeanPropertyRowMapper.newInstance(Oferta.class));
        return oferta;
    }

    /* Update – aktualizacja danych */
    public void update(Oferta oferta) {
        String sql="UPDATE POJAZDY SET numer_vin=:numer_vin,marka=:marka,model=:model,rok_produkcji=:rok_produkcji,numer_rejestracyjny=:numer_rejestracyjny,przebieg=:przebieg,rodzaj_paliwa=:rodzaj_paliwa,kolor=:kolor,moc_silnika=:moc_silnika,pojemnosc_bagaznika=:pojemnosc_bagaznika,cena=:cena,id_salonu=:id_salonu WHERE id_pojazdu=:id_pojazdu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(oferta);
        NamedParameterJdbcTemplate template =  new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
        String sql="DELETE FROM POJAZDY WHERE ID_POJAZDU=?";
        jdbcTemplate.update(sql,id);
    }

}
