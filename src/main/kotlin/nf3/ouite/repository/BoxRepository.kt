package nf3.ouite.repository

import nf3.ouite.model.Box
import org.springframework.data.jpa.repository.JpaRepository

interface BoxRepository: JpaRepository <Box, Long>
