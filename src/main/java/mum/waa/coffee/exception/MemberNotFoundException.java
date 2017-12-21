package mum.waa.coffee.exception;

public class MemberNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -7887870914061247522L;
	private Long memberId;
	private String message = "Member not found for this ID ";

	public MemberNotFoundException() {
	}

	public MemberNotFoundException(Long memberId, String message) {
		this.memberId = memberId;

		if (message != null)
			this.message = message;

	}

	public String getFullMessage() {
		return (message + memberId);
	}

	public Long getMemberId() {
		return memberId;
	}

	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}
}
