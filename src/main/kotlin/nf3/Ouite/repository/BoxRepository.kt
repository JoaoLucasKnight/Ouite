package nf3.Ouite.repository

import nf3.Ouite.Model.Box
import org.springframework.data.jpa.repository.JpaRepository

interface BoxRepository: JpaRepository <Box, Long> {
}