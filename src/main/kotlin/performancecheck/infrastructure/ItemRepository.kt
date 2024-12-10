package performancecheck.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import performancecheck.domain.Item

@Repository
interface ItemRepository : JpaRepository<Item, Int>
