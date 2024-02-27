package nf3.Ouite.repository

import nf3.Ouite.Model.Algo
import org.springframework.data.jpa.repository.JpaRepository

interface AlgoRepository : JpaRepository<Algo, Long> {
}