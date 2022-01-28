package repositories;

import java.util.List;

public interface EntityRepository<Entity> {
    Entity get(int id);
    List<Entity> getAll();
    boolean create(Entity entity);
    Entity delete(int id);
}
