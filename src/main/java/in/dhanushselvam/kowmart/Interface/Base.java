package in.dhanushselvam.kowmart.Interface;

import java.util.List;

public interface Base<T> {
		
		public abstract List<T> findAll();
		public abstract void create(T object);
		public abstract void update(int id, T object);
		public abstract void delete(int id);
		public abstract T findById(int id);

}
