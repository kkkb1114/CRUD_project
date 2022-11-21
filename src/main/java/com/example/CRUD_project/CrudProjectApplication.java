package com.example.CRUD_project;

import com.example.CRUD_project.tool.ToolManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@EnableJpaAuditing
@SpringBootApplication
public class CrudProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProjectApplication.class, args);
		//jpaProject02_EntityManagerFactory();
	}

	/** jpaProject02 ~~~ */
	/*public static void jpaProject02_EntityManagerFactory(){
		// [엔티티 매니저 팩토리] - 생성
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpabook");
		// [엔티티 매니저] - 생성
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// [트랜잭션] - 획득
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin(); // [트랜잭션] - 시작
			jpaProject02_logic(entityManager); // 비즈니스 로직 실행
			entityTransaction.commit();  // [트랜잭션] - 커밋
		} catch (Exception e) {
			entityTransaction.rollback(); // [트랜잭션] - 롤백
			e.printStackTrace();
		} finally {
			entityManager.close(); // [엔티티 매니저] - 종료
		}
		entityManagerFactory.close(); // [엔티티 매니저 팩토리] - 종료
	}*/

	// 비즈니스 로직
	/*public static void jpaProject02_logic(EntityManager entityManager){
		String id = "_id1";
		Member02 member02 = new Member02();
		member02.setId(id);
		member02.setUserName("기범");
		member02.setAge(29);

		System.out.println("내용: "+member02.getId()+member02.getUserName()+ member02.getAge());

		// 등록
		entityManager.persist(member02);

		// 수정
		member02.setAge(20);

		// 한 건 조회
		Member02 findAll = entityManager.find(Member02.class, id);
		System.out.println("내용2: "+findAll.getId()+findAll.getUserName()+ findAll.getAge());

		// 목록 조회
		List<Member02> member02List = entityManager.createQuery("select m from Member02 m", Member02.class).getResultList();
		System.out.println("내용3: "+member02List.size());

		// 삭제
		entityManager.remove(member02);
	}*/
	/** ~~~ jpaProject02 */


	/** jpaProject03 ~~~ */
	/*public static void jpaProject03_EntityManagerFactory(){

	}*/
	/** ~~~ jpaProject03 */


}
