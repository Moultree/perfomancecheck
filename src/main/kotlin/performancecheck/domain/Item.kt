package performancecheck.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Item(

    @Id
    var id: Int = 0,

    var name: String = ""
) {
    constructor() : this(0, "")
}