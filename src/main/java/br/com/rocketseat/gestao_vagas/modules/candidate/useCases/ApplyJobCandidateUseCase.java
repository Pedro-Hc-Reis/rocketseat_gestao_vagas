package br.com.rocketseat.gestao_vagas.modules.candidate.useCases;

import br.com.rocketseat.gestao_vagas.exceptions.JobNotFoundException;
import br.com.rocketseat.gestao_vagas.exceptions.UserNotFoundException;
import br.com.rocketseat.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.rocketseat.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import br.com.rocketseat.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import br.com.rocketseat.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ApplyJobRepository applyJobRepository;

    // ID do candidato
    // ID da vaga
    public ApplyJobEntity execute ( UUID idCandidate , UUID idJob ) {
        // Validar se o candidato existe
        this.candidateRepository.findById ( idCandidate )
                .orElseThrow ( UserNotFoundException::new );
        // Validar se a vaga existe
        this.jobRepository.findById ( idJob )
                .orElseThrow ( JobNotFoundException::new );
        // Candidato se inscrever na vaga
        var applyJob = ApplyJobEntity.builder ( )
                .candidateId ( idCandidate )
                .jobId ( idJob ).build ( );
        applyJob = applyJobRepository.save ( applyJob );
        return applyJob;
    }
}