package domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedMusicRepository extends CrudRepository<LikedMusic, Long> {
	public List<LikedMusic> findByIdUser(Long idUser);
}
