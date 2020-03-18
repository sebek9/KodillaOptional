package hibernate.task.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {
    List<Task> findByDuration(int duration);

 /*   @Query
    List<Task>retrieveLongTasks();

    @Query
    List<Task>retrieveShortTasks();

    @Query(nativeQuery = true)
    List<Task>retrieveTasksWithoutEnoughTime();

    @Query
    List<Task>retrieveTasksWitDurationLongerThan(@Param("DURATION") int duration);
*/
}